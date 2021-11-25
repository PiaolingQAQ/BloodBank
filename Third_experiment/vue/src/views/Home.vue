<template>
  <div style="padding: 10px">
<!--功能区-->
    <div style="margin: 10px 0px">
      <el-button type="primary" @click="add">新增</el-button>
      <el-button type="primary">导入</el-button>
      <el-button type="primary">导出</el-button>
    </div>
    <!--搜索区-->
    <div style="margin: 10px 0px">
      <el-input v-model="search" placeholder="请输入关键字" style="width: 20%" clearable/>
      <el-button type="primary" style="margin-left: 5px" @click="load" >查询</el-button>
    </div>
    <el-table :data="tableData" border stripe style="width: 100% ">
      <el-table-column type="selection" width="55" />
      <el-table-column prop="id" label="ID" sortable/>
      <el-table-column prop="username" label="血库名" />
      <el-table-column prop="nick_name" label="捐献者" />
      <el-table-column prop="blood_type" label="血型" />
      <el-table-column prop="blood_num" label="捐献血量" />
      <el-table-column prop="date" label="日期" />
      <el-table-column label="操作">
        <template #default="scope">
          <el-button size="mini" @click="handleEdit(scope.row)">编辑</el-button>
          <el-popconfirm title="确认删除?" @confirm="handleDelete(scope.row.id)">
            <template #reference>
              <el-button size="mini" type="danger">删除</el-button>
            </template>
          </el-popconfirm>
        </template>
      </el-table-column>
    </el-table>
    <div style="margin: 10px 0">
      <el-pagination
          :page-sizes="[5,10,20]"
          @current-page="currentPage"
          :page-size="pageSize"
          layout="total, sizes, prev, pager, next, jumper"
          :total="total"
          @size-change="handleSizeChange"
          @current-change="handleCurrentChange"
      >
      </el-pagination>
      <el-dialog
          v-model="dialogVisible"
          title="新增"
          width="30%">
        <el-form model="form" label-width="120px">
          <el-form-item label="血库名">
            <el-input v-model="form.username" style="width: 80%"></el-input>
          </el-form-item>
          <el-form-item label="捐献者">
            <el-input v-model="form.nick_name" style="width: 80%"></el-input>
          </el-form-item>
          <el-form-item label="捐献血量">
            <el-input v-model="form.blood_num" style="width: 80%"></el-input>
          </el-form-item>
          <el-form-item label="血型">
            <el-radio v-model="form.blood_type" label="O">O</el-radio>
            <el-radio v-model="form.blood_type" label="A">A</el-radio>
            <el-radio v-model="form.blood_type" label="B">B</el-radio>
            <el-radio v-model="form.blood_type" label="AB">AB</el-radio>
          </el-form-item>
          <el-form-item label="日期">
            <el-input type="textarea" v-model="form.date" style="width: 80%"></el-input>
          </el-form-item>
        </el-form>
        <template #footer>
      <span class="dialog-footer">
        <el-button @click="dialogVisible = false">取消</el-button>
        <el-button type="primary" @click="save">确认</el-button>
      </span>
        </template>
      </el-dialog>

    </div>
  </div>
</template>

<script>
import request from "../../utils/request";
import {ElMessage} from 'element-plus'
import Vue from "vue"
import {Message} from "element-plus";


export default {
  name: 'Home',
  components: {
  },
  data() {
    return {
      form:{},
      dialogVisible:false,
      search: '',
      currentPage:1,
      pageSize:this.handleSizeChange(),
      total:0,
      tableData: [

      ],
    }
  },
  created() {
    this.load()
  },
  methods:{
    load(){
      request.get("/api/user", {
        params: {
          pageNum: this.currentPage,
          pageSize: this.pageSize,
          search: this.search,
        }
      }).then(res=>{
        console.log(res)
        this.tableData=res.data.records
        this.total=res.data.total
      })
    },
    add(){
      //打开新增弹窗界面
      this.dialogVisible = true
      this.form={}
    },
    save() {
      if (this.form.id) {  // 更新
        request.put("/api/user", this.form).then(res => {
          console.log(res)
          if (res.code === '0') {
            ElMessage.success("更新成功")
          } else {
            ElMessage.error(res.msg)
          }
          this.load()     //刷新表格
          this.dialogVisible=false   //关闭弹窗
        })
      } else {  // 新增
        request.post("/api/user", this.form).then(res => {
          console.log(res)
          if (res.code === '0') {
            ElMessage.success("新增成功")
          } else {
            ElMessage.error(res.msg)
          }
          this.load()     //刷新表格
          this.dialogVisible=false   //关闭弹窗
        })
      }

    },
    handleEdit(row){
      this.form=JSON.parse(JSON.stringify(row))
      this.dialogVisible=true
    },
    handleDelete(id){
      console.log(id)
      request.delete("/api/user/"+id).then(res=>{
        if (res.code === '0') {
          ElMessage.success("删除成功")
        } else {
          ElMessage.error(res.msg)
        }
        this.load() //重新加载记录删除后的表格
      })
    },
    handleSizeChange(pageSize){     //改变每页的个数触发
      this.pageSize=pageSize
      this.load()
    },
    handleCurrentChange(pageNum){      //改变当前页码触发
      this.currentPage=pageNum
      this.load()
    },
  }
}
</script>

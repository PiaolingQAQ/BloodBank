<template>
  <div style="height: 50px; line-height: 50px; border-bottom: 1px solid #ccc;display: flex">
    <div style="width: 200px; padding-left: 30px; font-weight: bold; color: dodgerblue">全国血库联网管理系统</div>
    <div style="flex:1"></div>
    <div style="width: 100px">
      <el-dropdown>
        <span class="el-dropdown-link">
          武汉市洪山区血库
        <el-icon class="el-icon--right">
          <arrow-down />
        </el-icon>
        </span>
        <template #dropdown>
          <el-dropdown-menu>
            <el-dropdown-item>血库资料</el-dropdown-item>
            <el-dropdown-item>退出系统</el-dropdown-item>
          </el-dropdown-menu>
        </template>
      </el-dropdown>
    </div>
  </div>
</template>

<script>
import {ArrowDown} from "@element-plus/icons";
export default {
  name: "Header",
  components:{
    ArrowDown,
  }
}
</script>

<style scoped>

</style>
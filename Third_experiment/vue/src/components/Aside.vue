<template>
  <div>
    <el-menu
        active-text-color="#ffd04b"
        background-color="#545c64"
        style="width: 200px; min-height: calc(100vh - 50px)"
        default-active="2"
        text-color="#fff"
        class="el-menu-vertical-demo">
      <el-sub-menu index="1">
        <template #title>
          <el-icon><location /></el-icon>
          <span>血库信息</span>
        </template>
          <el-menu-item index="1">item one</el-menu-item>
      </el-sub-menu>
      <el-menu-item index="2">
        <el-icon><icon-menu /></el-icon>
        <span>献血记录</span>
      </el-menu-item>
      <el-menu-item index="3">
        <el-icon><document /></el-icon>
        <span>血液信息</span>
      </el-menu-item>
      <el-menu-item index="4">
        <el-icon><setting /></el-icon>
        <span>血液调配</span>
      </el-menu-item>
    </el-menu>
  </div>
</template>

<script>
import {defineComponent} from "vue";
import {Location,Document,Menu as IconMenu,Setting} from "@element-plus/icons";

export default {
  name: "Aside",
  components:{
    Location,
    Document,
    IconMenu,
    Setting,
  }
}
</script>

<style scoped>

</style>
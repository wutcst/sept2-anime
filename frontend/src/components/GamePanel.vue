<!--
* @FileDescription: vue游戏面板组件组件
-->
<script>
export default {
  //申明需要的数据
  props:["name","info","items"],
  data() {
    return {
      //是否显示房间的物品信息
      show:true
    }
  }
}
</script>

<template>
  <div class="panel">
    <el-text tag="b" size="large">
      你当前在<el-tag>{{name}}</el-tag>
    </el-text>
    <el-divider/>
    <el-alert title="房间信息" type="info" :description="info" :closable="false" :center="true" show-icon/>
    <el-alert/>
    <el-divider/>
    <el-button type="success" @click="show = !show">Look(查看物品)</el-button>
    <div style="margin-top: 20px; height: 200px">
      <el-collapse-transition>
        <div v-show="show">
          <el-descriptions title="物品总览" :column="3" size="small" border>
            <div v-for="item in items" :key="item">
              <el-descriptions-item label="物品名称">{{ item }}</el-descriptions-item>
              <el-descriptions-item label="描述">这是一个{{item}}</el-descriptions-item>
              <el-descriptions-item label="操作" :span="2"><el-button type="primary" size="small">拾取</el-button></el-descriptions-item>
            </div>
          </el-descriptions>
        </div>
      </el-collapse-transition>
    </div>
  </div>
</template>

<style scoped>
.panel{
  width: 28vw;
  display: inline-flex;
  flex-direction: column;
  justify-content: flex-start;
}
</style>
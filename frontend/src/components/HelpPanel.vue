<script>
export default {
  props:["tracks"],
  data() {
    return {
      tableData:[
        {
          key:"UP",
          op:"向上移动"
        },
        {
          key:"DOWN",
          op:"向下移动"
        },
        {
          key:"LEFT",
          op:"向左移动"
        },
        {
          key:"RIGHT",
          op:"向右移动"
        }
      ],
      tableData2:[
        {
          key:"ESC",
          op:"返回上个房间"
        },
        {
          key:"ENTER",
          op:"随机传送"
        },
      ],
      backN:1
    }
  }
}
</script>

<template>
  <div class="panel">
    <el-breadcrumb>
      <el-breadcrumb-item v-for="(track,index) in tracks" :key="track">
        <el-text v-if="index === tracks.length - 1" tag="mark">{{ track }}</el-text>
        <el-text v-else>{{ track }}</el-text>
      </el-breadcrumb-item>
    </el-breadcrumb>
    <div class="help">
      <el-table :data="tableData" style="width: 18vw" height="18vh">
        <el-table-column fixed prop="key" label="键位" width="100" />
        <el-table-column prop="op" label="操作" width="150" />
      </el-table>
      <el-table :data="tableData2" style="width: 18vw" height="18vh">
        <el-table-column fixed prop="key" label="键位" width="100" />
        <el-table-column prop="op" label="操作" width="150" />
      </el-table>
      <div class="group">
        <el-input-number v-model="backN" :min="1" :max="10"/>
        <el-button type="primary" plain>GoBackN</el-button>
      </div>
    </div>
  </div>
</template>

<style scoped>
.panel{
  width: 60vw;
  display: inline-flex;
  flex-direction: column;
  flex-wrap: wrap;
  justify-content: space-around;
  align-items: center;
}
.help{
  margin-top: 2vh;
  display: flex;
  flex-direction: row;
  justify-content: space-around;
  align-items: center;
}
.group{
  height: 18vh;
  margin-left: 2vw;
  display: inline-flex;
  flex-direction: column;
  justify-content: space-around;
  align-items: center;
}
</style>
<!--
* @FileDescription: vue地图组件
-->
<script>
export default {
  data() {
    return {
      //背景图片地址,尺寸30*30
      bg:[
        'https://s1.imgcap.xyz/ebbab847b15009dd4b39e9005616ee23.png',
        'https://s1.imgcap.xyz/aa7da080de92d8189a1dde2a657bfc71.png',
        'https://s1.imgcap.xyz/47a8e45d64b1117f4807d23268aabdc1.png'
      ],
      //存储地图的9*9二维数组,0为背景,1为墙壁
      map:Array.from({ length: 9 }, (_, rowIndex) =>
          Array.from({ length: 9 }, (_, colIndex) => this.getItemType(rowIndex + 1, colIndex + 1))
      ),
      //玩家的[行,列]坐标
      user:[5,5]
    }
  },
  computed: {
    //玩家的CSS计算属性,通过绝对定位显示在地图上
    userStyle(){
      return{
        position: 'absolute',
        top: (this.user[0]-1)*3 + 'vw',
        left: (this.user[1]-1)*3 + 'vw',
      };
    }
  },
  methods: {
    /**
     * 获取地图上元素的类型,0为背景,1为墙壁
     * @param row
     * @param col
     * @returns {number}
     */
    getItemType(row,col){
      if(row ===1 ||row === 9||col === 1||col === 9) {
        if (row === 5 || col === 5) {
          return 0;
        } else {
          return 1;
        }
      }
      else{
        return 0;
      }
    },
    /**
     * 监听方向键,改变玩家坐标
     * @param event
     */
    handleKeyDown(event) {
      switch (event.keyCode) {
        case 37: // 左箭头键
          this.user[1]--; //玩家列坐标减一
          break;
        case 38: // 上箭头键
          this.user[0]--;
          break;
        case 39: // 右箭头键
          this.user[1]++;
          break;
        case 40: // 下箭头键
          this.user[0]++;
          break;
      }
    }
  },
  mounted() {
    window.addEventListener('keydown', this.handleKeyDown);
  },
  beforeUnmount() {
    window.removeEventListener('keydown', this.handleKeyDown);
  },
}

</script>

<template>
  <div class="map">
    <div v-for="row in map" class="row">
      <span v-for="item in row">
        <img :src="bg[item]" />
      </span>
    </div>
    <!--通过绝对定位让玩家图片在地图上显示-->
    <img :src="bg[2]" :style="userStyle" />
  </div>
</template>

<style scoped>
.map{
  width:27vw;
  display: flex;
  position: relative;
  flex-direction: row;
  flex-wrap:wrap;
  align-items: flex-start;
  align-content: flex-start;
}
.row{
  margin:0;
  padding:0;
  font-size:0;
}
img{
  width:3vw;
  height: auto;
  border: 1px solid #ffffff; /* 添加白色边框 */
}
</style>

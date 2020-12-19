<template>
  <el-row :gutter="40" class="panel-group">
    <el-col :xs="12" :sm="12"  :lg="6" class="card-panel-col">
      <div class="card-panel" @click="$router.push('/table/taobao')">
        <div class="card-panel-icon-wrapper icon-people">
       <svg-icon icon-class="message" class-name="card-panel-icon" />
        </div>
        <div class="card-panel-description">
          <div class="card-panel-text">
            <h3>淘宝商品列表历史数据</h3>
			<span>爬取条数:</span>
			  <count-to :start-val="0" :end-val="102400" :duration="2600" class="card-panel-num" />
          </div>

        </div>
      </div>
    </el-col>

   <el-col :xs="12" :sm="12"  :lg="6" class="card-panel-col">
     <div class="card-panel" @click="$router.push('/table/jingdong')">
       <div class="card-panel-icon-wrapper icon-people">
      <svg-icon icon-class="message" class-name="card-panel-icon" />
       </div>
       <div class="card-panel-description">
         <div class="card-panel-text">
           <h3>京东商品列表历史数据</h3>
   		<span>爬取条数:</span>
   		  <count-to :start-val="0" :end-val="102400" :duration="2600" class="card-panel-num" />
         </div>

       </div>
     </div>
   </el-col>
   <el-col :xs="12" :sm="12"  :lg="6" class="card-panel-col">
     <div class="card-panel" @click="$router.push('/table/tianmao')">
       <div class="card-panel-icon-wrapper icon-people">
      <svg-icon icon-class="message" class-name="card-panel-icon" />
       </div>
       <div class="card-panel-description">
         <div class="card-panel-text">
           <h3>天猫商品列表历史数据</h3>
   		<span>爬取条数:</span>
   		  <count-to :start-val="0" :end-val="102400" :duration="2600" class="card-panel-num" />
         </div>

       </div>
     </div>
   </el-col>
   <el-col :xs="12" :sm="12"  :lg="6" class="card-panel-col">
     <div class="card-panel" @click="$router.push('/table/suningyigou')">
       <div class="card-panel-icon-wrapper icon-people">
      <svg-icon icon-class="message" class-name="card-panel-icon" />
       </div>
       <div class="card-panel-description">
         <div class="card-panel-text">
           <h3>苏宁易购商品列表历史数据</h3>
   		<span>爬取条数:</span>
   		  <count-to :start-val="0" :end-val="102400" :duration="2600" class="card-panel-num" />
         </div>

       </div>
     </div>
   </el-col>
   <el-col :xs="12" :sm="12"  :lg="6" class="card-panel-col">
     <div class="card-panel" @click="$router.push('/table/dangdang')">
       <div class="card-panel-icon-wrapper icon-people">
      <svg-icon icon-class="message" class-name="card-panel-icon" />
       </div>
       <div class="card-panel-description">
         <div class="card-panel-text">
           <h3>当当网商品列表历史数据</h3>
   		<span>爬取条数:</span>
   		  <count-to :start-val="0" :end-val="102400" :duration="2600" class="card-panel-num" />
         </div>

       </div>
     </div>
   </el-col>
   <el-col :xs="12" :sm="12"  :lg="6" class="card-panel-col">
     <div class="card-panel" @click="$router.push('/table/weipinhui')">
       <div class="card-panel-icon-wrapper icon-people">
      <svg-icon icon-class="message" class-name="card-panel-icon" />
       </div>
       <div class="card-panel-description">
         <div class="card-panel-text">
           <h3>唯品会商品列表历史数据</h3>
   		<span>爬取条数:</span>
   		  <count-to :start-val="0" :end-val="102400" :duration="2600" class="card-panel-num" />
         </div>

       </div>
     </div>
   </el-col>
   <el-col :xs="12" :sm="12"  :lg="6" class="card-panel-col">
     <div class="card-panel" @click="$router.push('/table/yamaxun')">
       <div class="card-panel-icon-wrapper icon-people">
      <svg-icon icon-class="message" class-name="card-panel-icon" />
       </div>
       <div class="card-panel-description">
         <div class="card-panel-text">
           <h3>亚马逊商品列表历史数据</h3>
   		<span>爬取条数:</span>
   		  <count-to :start-val="0" :end-val="102400" :duration="2600" class="card-panel-num" />
         </div>

       </div>
     </div>
   </el-col>
   <el-col :xs="12" :sm="12"  :lg="6" class="card-panel-col">
     <div class="card-panel" @click="$router.push('/table/huicong')">
       <div class="card-panel-icon-wrapper icon-people">
      <svg-icon icon-class="message" class-name="card-panel-icon" />
       </div>
       <div class="card-panel-description">
         <div class="card-panel-text">
           <h3>慧聪网商品列表历史数据</h3>
   		<span>爬取条数:</span>
   		  <count-to :start-val="0" :end-val="102400" :duration="2600" class="card-panel-num" />
         </div>

       </div>
     </div>
   </el-col>

  </el-row>


</template>

<script>
import CountTo from 'vue-count-to'

export default {
  components: {
    CountTo
  },
  methods: {
    // handleSetLineChartData(type) {
    //   this.$emit('handleSetLineChartData', type)
    // }
	// showData(){
	// 	this.$router.push({name:''})
	// }
  }
}
</script>

<style lang="scss" scoped>
.panel-group {
  margin-top: 18px;

  .card-panel-col {
    margin-bottom: 32px;

  }

  .card-panel {
    height: 270px;
    cursor: pointer;
    font-size: 12px;
    position: relative;
    overflow: hidden;
    color: #666;
    background: #fff;
    box-shadow: 4px 4px 40px rgba(0, 0, 0, .05);
    border-color: rgba(0, 0, 0, .05);

    &:hover {
      .card-panel-icon-wrapper {
        color: #fff;
      }

      .icon-people {
        background: #40c9c6;
      }


    }

    .icon-people {
      color: #40c9c6;
    }



    .card-panel-icon-wrapper {
      float: left;
      margin: 15px 0 0 30px;
      padding: 16px;
      transition: all 0.38s ease-out;
      border-radius: 6px;
    }

    .card-panel-icon {
      float: left;
      font-size: 48px;
    }

    .card-panel-description {
		width:240px ;
		height: 180px;
      float: right;
      font-weight: bold;

      .card-panel-text {
		  width:240px ;
		  height: 100px;
		  margin-top: 60px;
        color: rgba(0, 0, 0, 0.45);
		padding-right: 20px;
		h3{
			font-family:YouYuan ;
			font-size: 28px;
			color:rgb(121,121,121);
			margin-right: 10px;
		}
		span{

			font-family:YouYuan;
			font-size: 18px ;
			color: rgba(81,81,81,.6);
		}
      }

      .card-panel-num {
        font-size: 15px;
		color: darkgray;

      }
    }
  }
}

@media (max-width:550px) {
  .card-panel-description {
    display: none;
  }

  .card-panel-icon-wrapper {
    float: none !important;
    width: 100%;
    height: 100%;
    margin: 0 !important;

    .svg-icon {
      display: block;
      margin: 14px auto !important;
      float: none !important;
    }
  }
}
</style>

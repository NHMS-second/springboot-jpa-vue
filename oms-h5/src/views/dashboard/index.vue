<template>
  <div class="dashboard-container">
    <span style="float:right;color:#8492A6;margin:10px;font-size:16px">
      当前系统时间:<span v-text="time"></span>
    </span>
    <div style="padding:10px;clear:both">
      <el-row :gutter="20">
        <el-col :span="6">
          <el-card class="box-card">
            <div>设备ID资源总数:<span v-text="totalDeviceKeyNum"></span></div>
            <div>已使用:<span v-text="usedDeviceKeyNum"></span></div>
            <div>未使用:<span v-text="notUsedDeviceKeyNum"></span></div>
          </el-card>
        </el-col>
        <el-col :span="6">
          <el-card class="box-card">
            <div style="line-height:100px;text-align:center;verticle-align:middle;">今日新增用户:<span v-text="todayMemberCount"></span></div>
          </el-card>
        </el-col>
        <el-col :span="6">
          <el-card class="box-card">
            <div>设备总数:<span v-text="allDeviceNum"></span></div>
            <div>设备在线数:<span v-text="onlineDeviceNum"></span></div>
            <div>设备离线数:<span v-text="offlineDeviceNum"></span></div>
            <div>设备异常数:<span v-text="errorDeviceNum"></span></div>
          </el-card>
        </el-col>
      </el-row>
    </div>
    <el-card style="margin:10px">
      <div>
          <el-date-picker v-model="month" type="month" format="yyyy-MM-dd" placeholder="选择月">
          </el-date-picker>
          <el-button class="filter-item" type="primary" v-waves icon="search" @click="handleSearchDeviceNum">{{$t('message.search')}}</el-button>
          <div id="deviceChart" style="width:100%;height:450px;"></div>
      </div>
    
    </el-card>
  </div>
</template>

<script>
import moment from 'moment'
import echarts from 'echarts'
import waves from '@/directive/waves.js'// 水波纹指令
import { dashboard, currentTime, statisticsDevice } from '@/api/dashboard'
import { mapGetters } from 'vuex'
import adminDashboard from './admin/index'
import editorDashboard from './editor/index'

export default {
  name: 'dashboard',
  components: { adminDashboard, editorDashboard },
  directives: {
    waves
  },
  data() {
    return {
      currentRole: 'adminDashboard',
      notUsedDeviceKeyNum: 0,
      usedDeviceKeyNum: 0,
      totalDeviceKeyNum: 0,
      todayMemberCount: 0,
      errorDeviceNum: 0,
      offlineDeviceNum: 0,
      onlineDeviceNum: 0,
      allDeviceNum: 0,
      time: '',
      month: '',
      deviceChart: undefined
    }
  },
  computed: {
    ...mapGetters([
      'roles'
    ])
  },
  created() {
    dashboard().then(response => {
      this.allDeviceNum = response.allDeviceNum
      this.onlineDeviceNum = response.onlineDeviceNum
      this.offlineDeviceNum = response.offlineDeviceNum
      this.errorDeviceNum = response.errorDeviceNum
      this.totalDeviceKeyNum = response.totalDeviceKeyNum
      this.usedDeviceKeyNum = response.usedDeviceKeyNum
      this.notUsedDeviceKeyNum = response.notUsedDeviceKeyNum
      this.todayMemberCount = response.todayMemberCount
    })
    setInterval(() => {
      currentTime().then(response => {
        this.time = response.time
      })
    }, 1000)
    this.handleSearchDeviceNum()
    if (this.roles.indexOf('admin') >= 0) {
      return
    }
    this.currentRole = 'editorDashboard'
  },
  methods: {
    handleSearchDeviceNum() {
      console.log(this.month)
      var monthStr
      if (this.month) {
        monthStr = moment(this.month).format('YYYY-MM-DD')
      }
      statisticsDevice(monthStr).then(response => {
        var days = []
        var nums = []
        for (var key in response.data) {
          days.push(key)
          nums.push(response.data[key])
        }
        var options = {
          title: {
            text: '每日新增设备统计'
          },
          tooltip: {
            trigger: 'axis',
            axisPointer: {
              type: 'cross',
              label: {
                backgroundColor: '#6a7985'
              }
            }
          },
          xAxis: {
            type: 'category',
            boundaryGap: false,
            data: days
          },
          yAxis: {
            minInterval: 1,
            type: 'value'
          },
          series: [{
            data: nums,
            type: 'line',
            areaStyle: { normal: {}}
          }]
        }
        this.deviceChart = echarts.init(document.getElementById('deviceChart'))
        this.deviceChart.setOption(options)
      })
    }
  }
}
</script>
<style>
  .box-card div{
    margin-bottom: 20px;    
  }
  .box-card div:last-child{
    margin-bottom: 0;    
  }
  .box-card{
    height: 180px;
  }
</style>

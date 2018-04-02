<template>
<div class="app-container calendar-list-container">
  <!-- 筛选条件 -->
  <div class="filter-container">
    <el-input @keyup.enter.native="handleSearch" style="width: 120px;" class="filter-item" :placeholder="$t('deviceKey.qniqueId')" v-model="params.search_like_deviceUniqueId"></el-input>
  <el-input @keyup.enter.native="handleSearch" style="width: 120px;" class="filter-item" :placeholder="$t('deviceKey.key')" v-model="params.search_like_deviceKey"></el-input>
    <el-select v-model="params.search_eq_status" style="width: 120px" class="filter-item" clearable :placeholder="$t('message.status')">
      <el-option v-for="item in options.status"
        :key="item.value"
        :label="item.label"
        :value="item.value">
      </el-option>
    </el-select>

    <el-button class="filter-item" type="primary" v-waves icon="search" @click="handleSearch">{{$t('message.search')}}</el-button>
     <el-button class="filter-item pull-right" type="success" icon="edit" @click="dialogVisible = true">{{$t('message.import')}}</el-button>
    <el-button class="filter-item pull-right" type="success" icon="edit" @click="handleCreate">{{$t('message.add')}}</el-button>

     <el-dialog
  :title="$t('deviceKey.import')"
  :visible.sync="dialogVisible"
  width="30%"
  :before-close="handleClose">
  
        <el-upload
        class="upload-demo"
        action="/api/importExcel"
        :limit="1"
        :on-success="handleSuccess">
        <el-button size="small" type="primary">{{$t('firmware.clickUpload')}}</el-button>
        <div slot="tip" class="el-upload__tip">{{$t('deviceKey.import')}}</div>
      </el-upload>

</el-dialog>

  </div>

  <!-- 列表数据 -->
  <Pagination uri="/device/keys" :request-params="params" ref="pagination">

      <!-- 设备唯一ID -->
      <el-table-column align="center" :label="$t('deviceKey.qniqueId')">
        <template scope="scope">
          <span>{{scope.row.deviceUniqueId}}</span>
        </template>
      </el-table-column>

      <!-- 设备唯一KEY -->
      <el-table-column align="center" :label="$t('deviceKey.key')">
        <template scope="scope">
          <span>{{scope.row.deviceKey}}</span>
        </template>
      </el-table-column>

      <!-- 设备状态 -->
      <el-table-column align="center" :label="$t('message.status')">
        <template scope="scope">
          <span v-if="scope.row.status == 0">{{$t('deviceKey.noUsered')}}</span>
          <span v-if="scope.row.status == 1">{{$t('deviceKey.usered')}}</span>
        </template>
      </el-table-column>

<!--     
      <el-table-column align="center" :label="$t('device.nickname')">
        <template scope="scope">
          <span v-if="scope.row.device">{{scope.row.device.nickname}}</span>
        </template>
      </el-table-column> -->

      <!-- 创建时间 -->
      <el-table-column align="center" :label="$t('message.createTime')">
        <template scope="scope">
          <span>{{scope.row.createdTime | parseTime('{y}-{m}-{d} {h}:{i}')}}</span>
        </template>
      </el-table-column>

    <el-table-column :label="$t('message.handle')" align="center" width="150">
      <template scope="scope">
        <!-- <el-button v-if="scope.row.status === 1" size="small" type="text" @click="handleUpdateStatus(scope.row, 0)">禁用</el-button>
        <el-button v-if="scope.row.status === 0" size="small" type="text" @click="handleUpdateStatus(scope.row, 1)">启用</el-button> -->
        <el-button size="small" type="text" @click="handleEdit(scope.row.id)">{{$t('message.edit')}}</el-button>
        <el-button size="small" type="text" class="danger" @click="handleDelete(scope.row)">{{$t('message.delete')}}</el-button>
      </template>
    </el-table-column>
  </Pagination>
</div>
</template>

<script>
import { remove, updateStatus } from '@/api/device/key'
import waves from '@/directive/waves.js'// 水波纹指令
import Pagination from '@/components/Pagination'
import Status from '@/components/Status'
import { Notification } from 'element-ui'

export default {
  name: 'deviceKey_list',
  components: { Pagination, Status },
  directives: {
    waves
  },
  data() {
    return {
      dialogVisible: false,
      params: {
        search_like_deviceUniqueId: undefined,
        search_like_deviceKey: undefined,
        search_eq_status: undefined
      },

      options: {
        status: [
          { value: 0, label: this.$t('deviceKey.noUsered') },
          { value: 1, label: this.$t('deviceKey.usered') }
        ]
      }
    }
  },
  created() {
  },
  methods: {
    /**
     * 搜索设备唯一序列号
     */
    handleSearch() {
      this.$refs.pagination.pageRequest()
    },

    handleSuccess(response, file, fileList) {
      console.log('response:' + response)
      console.log('err_code:' + response.err_code)
      console.log('err_msg:' + response.err_msg)
      if (response.err_code !== 0) {
        Notification.error({
          title: '失败',
          message: response.err_msg,
          duration: 2000
        })
      } else {
        Notification.success({
          title: '成功',
          message: '上传成功',
          duration: 2000
        })
      }
    },

    handleClose(done) {
      this.$confirm('确认关闭？')
          .then(_ => {
            done()
          })
          .catch(_ => {})
    },

    /**
     * 编辑设备唯一序列号
     */
    handleEdit(id) {
      this.$router.push({ path: '/device/key/edit', query: { id: id }})
    },

    /**
     * 创建设备唯一序列号
     */
    handleCreate() {
      this.$router.push({ path: '/device/key/edit' })
    },

    handleImport() {
      this.$router.push({ path: '/device/key/edit' })
    },

    /**
     * 更新设备唯一序列号状态
     */
    handleUpdateStatus(row, status) {
      updateStatus(row.id, status).then(response => {
        this.handleSearch()
      })
    },

    /**
     * 删除设备唯一序列号
     */
    handleDelete(row) {
      this.$confirm('确认删除该设备唯一序列号？').then(_ => {
        remove(row.id).then(response => {
          this.$refs.pagination.removeItem(row)
        })
      }).catch(_ => {})
    }
  }
}
</script>


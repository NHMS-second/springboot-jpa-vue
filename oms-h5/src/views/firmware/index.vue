<template>
<div class="app-container calendar-list-container">
  <!-- 筛选条件 -->
  <div class="filter-container">
    <el-input @keyup.enter.native="handleSearch" style="width: 120px;" class="filter-item" :placeholder="$t('firmware.revision')" v-model="params.search_like_revision"></el-input>
  <el-input @keyup.enter.native="handleSearch" style="width: 120px;" class="filter-item" :placeholder="$t('firmware.name')" v-model="params.search_like_name"></el-input>

<!-- <el-select v-model="params.search_eq_chipType" style="width: 120px" class="filter-item" clearable :placeholder="$t('firmware.chipType')">
      <el-option v-for="item in chip.type"
        :key="item.value"
        :label="item.label"
        :value="item.value">
      </el-option>
    </el-select> -->

    <el-select v-model="params.search_eq_type" style="width: 120px" class="filter-item" clearable :placeholder="$t('firmware.type')">
      <el-option v-for="item in type.options"
        :key="item.value"
        :label="item.label"
        :value="item.value">
      </el-option>
    </el-select>

    
    <el-button class="filter-item" type="primary" v-waves icon="search" @click="handleSearch">{{$t('message.search')}}</el-button>
    <el-button class="filter-item pull-right" type="success" icon="edit" @click="handleCreate">{{$t('message.add')}}</el-button>

   

  </div>

  <!-- 列表数据 -->
  <Pagination uri="/firmwares" :request-params="params" ref="pagination">

      <!-- 版本号 -->
      <el-table-column align="center" :label="$t('firmware.revision')">
        <template scope="scope">
          <span>{{scope.row.revision}}</span>
        </template>
      </el-table-column>

      <!-- 文本名称 -->
      <el-table-column align="center" :label="$t('firmware.name')">
        <template scope="scope">
          <span>{{scope.row.name}}</span>
        </template>
      </el-table-column>


      <!-- 设备类型 -->
      <!-- <el-table-column align="center" :label="$t('firmware.chipType')">
        <template scope="scope">
          <span>{{scope.row.chipTypeStr}}</span>
        </template>
      </el-table-column> -->

      <!-- 文件大小 -->
      <el-table-column align="center" :label="$t('firmware.bytes')">
        <template scope="scope">
          <span>{{scope.row.bytes}}bytes</span>
        </template>
      </el-table-column>

      <!-- 升级状态 -->
      <el-table-column align="center" :label="$t('firmware.type')">
        <template scope="scope">
          <span>{{scope.row.typeStr}}</span>
        </template>
      </el-table-column>

      <!-- 创建时间 -->
      <el-table-column align="center" :label="$t('message.createTime')">
        <template scope="scope">
          <span>{{scope.row.createdTime | parseTime('{y}-{m}-{d} {h}:{i}')}}</span>
        </template>
      </el-table-column>

    <el-table-column :label="$t('message.handle')" align="center" width="150">
      <template scope="scope">
        <el-button size="small" type="text" @click="handleEdit(scope.row.id)">{{$t('message.edit')}}</el-button>
        <el-button size="small" type="text" class="danger" @click="handleDelete(scope.row)">{{$t('message.delete')}}</el-button>
      </template>
    </el-table-column>
  </Pagination>
</div>
</template>

<script>
import { remove } from '@/api/firmware'
import waves from '@/directive/waves.js'// 水波纹指令
import Pagination from '@/components/Pagination'

export default {
  name: 'firmware_list',
  components: { Pagination },
  directives: {
    waves
  },
  data() {
    return {
      params: {
        search_like_revision: undefined,
        search_like_name: undefined,
        search_eq_type: undefined,
        search_eq_chipType: undefined
      },
      chip: {
        type: [
          { value: 1, label: 'muc' },
          { value: 2, label: 'dsp' }
        ]
      },
      type: {
        options: [
          { value: 0, label: this.$t('firmware.noforce') },
          { value: 1, label: this.$t('firmware.force') }
        ]
      }
    }
  },
  created() {
  },
  methods: {
    /**
     * 搜索设备固件
     */
    handleSearch() {
      this.$refs.pagination.pageRequest()
    },

    /**
     * 编辑设备固件
     */
    handleEdit(id) {
      this.$router.push({ path: '/firmware/edit', query: { id: id }})
    },

    /**
     * 创建设备固件
     */
    handleCreate() {
      /* this.$router.push({ path: '/firmware/edit' }) */
      this.$router.push({ path: '/firmware/edit' })
    },

    /**
     * 删除设备固件
     */
    handleDelete(row) {
      this.$confirm('确认删除该设备固件？').then(_ => {
        remove(row.id).then(response => {
          this.$refs.pagination.removeItem(row)
        })
      }).catch(_ => {})
    }
  }
}
</script>


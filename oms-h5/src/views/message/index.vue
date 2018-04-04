<template>
<div class="app-container calendar-list-container">
  <!-- 筛选条件 -->
  <div class="filter-container">
    <el-input @keyup.enter.native="handleSearch" style="width: 120px;" class="filter-item" :placeholder="$t('mes.title')" v-model="params.search_like_title"></el-input>

    <el-button class="filter-item" type="primary" v-waves icon="search" @click="handleSearch">{{$t('message.search')}}</el-button>
    <el-button class="filter-item pull-right" type="success" icon="edit" @click="handleCreate">{{$t('message.add')}}</el-button>
  </div>

  <!-- 列表数据 -->
  <Pagination uri="/messages" :request-params="params" ref="pagination">


      <!--  -->
      <el-table-column align="center" :label="$t('mes.title')">
        <template scope="scope">
          <span>{{scope.row.title}}</span>
        </template>
      </el-table-column>

      <!-- <el-table-column align="center" :label="$t('mes.img')">
        <template scope="scope">
          <img :width="60" :height="60" :src="scope.row.img" />
        </template>
      </el-table-column> -->

      <!-- 消息类型 1系统消息 2个人消息 -->
      <!-- <el-table-column align="center" :label="$t('mes.type')">
        <template scope="scope">
          <span v-if='scope.row.type==1'>{{$t('mes.system')}}</span>
          <span v-if='scope.row.type==2'>{{$t('mes.personal')}}</span>
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
        <el-button size="small" type="text" @click="handleEdit(scope.row.id)">{{$t('message.edit')}}</el-button>
      </template>
    </el-table-column>
  </Pagination>
</div>
</template>

<script>
import { remove } from '@/api/message'
import waves from '@/directive/waves.js'// 水波纹指令
import Pagination from '@/components/Pagination'

export default {
  name: 'message_list',
  components: { Pagination },
  directives: {
    waves
  },
  data() {
    return {
      params: {
        search_like_title: undefined
      }
    }
  },
  created() {
  },
  methods: {
    /**
     * 搜索系统消息
     */
    handleSearch() {
      this.$refs.pagination.pageRequest()
    },

    /**
     * 编辑系统消息
     */
    handleEdit(id) {
      this.$router.push({ path: '/message/edit', query: { id: id }})
    },

    /**
     * 创建系统消息
     */
    handleCreate() {
      this.$router.push({ path: '/message/edit' })
    },

    /**
     * 删除系统消息
     */
    handleDelete(row) {
      this.$confirm('确认删除该系统消息？').then(_ => {
        remove(row.id).then(response => {
          this.$refs.pagination.removeItem(row)
        })
      }).catch(_ => {})
    }
  }
}
</script>


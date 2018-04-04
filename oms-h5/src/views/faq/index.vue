<template>
<div class="app-container calendar-list-container">
  <!-- 筛选条件 -->
  <div class="filter-container">
    <el-input @keyup.enter.native="handleSearch" style="width: 120px;" class="filter-item" :placeholder="$t('faq.title')" v-model="params.search_like_title"></el-input>
    
    <el-button class="filter-item" type="primary" v-waves icon="search" @click="handleSearch">{{$t('message.search')}}</el-button>
    <el-button class="filter-item pull-right" type="success" icon="edit" @click="handleCreate">{{$t('message.add')}}</el-button>
  </div>

  <!-- 列表数据 -->
  <Pagination uri="/faqs" :request-params="params" ref="pagination">

      <!-- 问题标题 -->
      <el-table-column align="center" :label="$t('faq.title')">
        <template scope="scope">
          <span>{{scope.row.title}}</span>
        </template>
      </el-table-column>

      <!-- 问题答案 -->
      <!-- <el-table-column align="center" label="问题答案">
        <template scope="scope">
          <span>{{scope.row.content}}</span>
        </template>
      </el-table-column> -->

      <!-- 排序（越大越靠前） -->
      <el-table-column align="center" :label="$t('message.sort')">
        <template scope="scope">
          <span>{{scope.row.sort}}</span>
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
import { remove } from '@/api/faq'
import waves from '@/directive/waves.js'// 水波纹指令
import Pagination from '@/components/Pagination'

export default {
  name: 'faq_list',
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
     * 搜索常见问题
     */
    handleSearch() {
      this.$refs.pagination.pageRequest()
    },

    /**
     * 编辑常见问题
     */
    handleEdit(id) {
      this.$router.push({ path: '/faq/edit', query: { id: id }})
    },

    /**
     * 创建常见问题
     */
    handleCreate() {
      this.$router.push({ path: '/faq/edit' })
    },

    /**
     * 删除常见问题
     */
    handleDelete(row) {
      this.$confirm('确认删除该常见问题？').then(_ => {
        remove(row.id).then(response => {
          this.$refs.pagination.removeItem(row)
        })
      }).catch(_ => {})
    }
  }
}
</script>


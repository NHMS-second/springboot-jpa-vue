<template>
<div class="app-container calendar-list-container">
  <!-- 筛选条件 -->
  <div class="filter-container">
  </div>

  <!-- 列表数据 -->
  <Pagination uri="/member/opinions" :request-params="params" ref="pagination">

  

      <!-- 联系方式 -->
      <el-table-column align="center" label="联系方式">
        <template scope="scope">
          <span>{{scope.row.contact}}</span>
        </template>
      </el-table-column>

      <!-- 意见 -->
      <el-table-column align="center" label="意见">
        <template scope="scope">
          <span>{{scope.row.content}}</span>
        </template>
      </el-table-column>

      <!-- 创建时间 -->
      <el-table-column align="center" label="创建时间">
        <template scope="scope">
          <span>{{scope.row.createdTime | parseTime('{y}-{m}-{d} {h}:{i}')}}</span>
        </template>
      </el-table-column>

  </Pagination>
</div>
</template>

<script>
import { remove } from '@/api//member/opinion'
import waves from '@/directive/waves.js'// 水波纹指令
import Pagination from '@/components/Pagination'

export default {
  name: 'memberOpinion_list',
  components: { Pagination },
  directives: {
    waves
  },
  data() {
    return {
      params: {
      }
    }
  },
  created() {
  },
  methods: {
    /**
     * 搜索用户反馈
     */
    handleSearch() {
      this.$refs.pagination.pageRequest()
    },

    /**
     * 编辑用户反馈
     */
    handleEdit(id) {
      this.$router.push({ path: '/member/opinion/edit', query: { id: id }})
    },

    /**
     * 创建用户反馈
     */
    handleCreate() {
      this.$router.push({ path: '/member/opinion/edit' })
    },

    /**
     * 删除用户反馈
     */
    handleDelete(row) {
      this.$confirm('确认删除该用户反馈？').then(_ => {
        remove(row.id).then(response => {
          this.$refs.pagination.removeItem(row)
        })
      }).catch(_ => {})
    }
  }
}
</script>


<template>
  <div class="app-container app-edit">
    <el-form class="small-space" :model="form" :rules="rules" ref="form" label-position="right" label-width="120px" style="width: 700px;">

      <!-- 问题标题 -->
      <el-form-item :label="$t('faq.title')" prop="title">
        <el-input v-model="form.title" :placeholder="$t('faq.title')"></el-input>
      </el-form-item>

      <el-form-item :label="$t('faq.answer')" prop="content">
      <div class="editor-container">
          <tinymce :height=400 ref="editor" v-model="form.content"></tinymce>
        </div>
      </el-form-item>

      <!-- 排序（越大越靠前） -->
      <el-form-item :label="$t('message.sort')" prop="sort">
        <el-input-number v-model="form.sort" :min="0"></el-input-number>
      </el-form-item>

      <el-form-item>
        <el-button type="primary" :loading="onSubmit" @click="handleSave">{{$t('message.save')}}</el-button>
        <el-button @click="handleCancel">{{$t('message.cancel')}}</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
import { find, save } from '@/api/faq'
import Tinymce from '@/components/Tinymce'

export default {
  components: { Tinymce },
  data() {
    return {
      form: {
        id: undefined,
        title: '',
        content: '',
        sort: ''
      },

      onSubmit: false,

      // 表单验证规则
      rules: {
//        mobile: [
//          { required: true, message: '请输入手机号码', trigger: 'blur' }
//        ],
//        username: [
//          { required: true, message: '请输入姓名', trigger: 'blur' },
//          { max: 15, message: '姓名长度不能超过15个字符', trigger: 'blur' }
//        ],
//        email: [
//          { required: true, message: '请输入邮箱', trigger: 'blur' },
//          { type: 'email', message: '您输入的邮箱格式不正确', trigger: 'blur' }
//        ],
//        password: [
//          { required: true, message: '请输入密码', trigger: 'blur' },
//          { min: 6, message: '密码长度不能少于6个字符', trigger: 'blur' }
//        ]
      }
    }
  },
  created() {
    if (this.$route.query.id) {
      this.form.id = this.$route.query.id
      this.findById(this.form.id)
    }
  },
  methods: {
    /**
     * 查询常见问题
     */
    findById(id) {
      find(id).then(response => {
        this.form.title = response.faq.title
        this.form.content = response.faq.content
        this.form.sort = response.faq.sort
      })
    },

    /**
     * 保存常见问题
     */
    handleSave() {
      this.$refs.form.validate(valid => {
        if (!valid) {
          return false
        }

        this.onSubmit = true
        save(this.form).then(response => {
          this.$router.go(-1)
        }).finally(() => {
          this.onSubmit = false
        })
      })
    },

    /**
     * 取消
     */
    handleCancel() {
      this.$router.go(-1)
    }
  }
}
</script>

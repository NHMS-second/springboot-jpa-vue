<template>
  <div class="app-container app-edit">
    <el-form class="small-space" :model="form" :rules="rules" ref="form" label-position="right" label-width="120px" style="width: 700px;">

      

      <!--  -->
      <el-form-item :label="$t('mes.title')" prop="title">
        <el-input v-model="form.title" :placeholder="$t('mes.title')"></el-input>
      </el-form-item>

      <!-- 消息类型 1系统消息 2个人消息 -->
      <!-- <el-form-item :label="$t('mes.type')" prop="type">
        <el-select v-model="form.type" style="width: 120px" class="filter-item" clearable :placeholder="$t('mes.type')">
          <el-option v-for="item in type.options"
            :key="item.value"
            :label="item.label"
            :value="item.value">
          </el-option>
        </el-select>
      </el-form-item> -->


      <!-- <el-upload
        class="avatar-uploader"
        action="https://jsonplaceholder.typicode.com/posts/"
        :show-file-list="false"
        :on-success="handleAvatarSuccess"
        :before-upload="beforeAvatarUpload">
        <img v-if="imageUrl" :src="imageUrl" class="avatar">
        <i v-else class="el-icon-plus avatar-uploader-icon"></i>
      </el-upload> -->

      <!-- <el-form-item label="图片" prop="img">
        <UploadImgs :fileList="params.businessLicense" :maxSize="1" ref="businessLicense"></UploadImgs>
      </el-form-item> -->


     <!--  
      <el-form-item label="" prop="img">
        <el-input v-model="form.img" placeholder="请输入"></el-input>
      </el-form-item> -->

      <el-form-item :label="$t('mes.content')" prop="content">
      <div class="editor-container">
          <tinymce :height=400 ref="editor" v-model="form.content"></tinymce>
        </div>
      </el-form-item>



      <el-form-item>
        <el-button type="primary" :loading="onSubmit" @click="handleSave">{{$t('message.save')}}</el-button>
        <el-button @click="handleCancel">{{$t('message.cancel')}}</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
import { find, save } from '@/api/message'
import UploadImgs from '@/components/UploadImgs'
import Tinymce from '@/components/Tinymce'

export default {
  components: { UploadImgs, Tinymce },
  data() {
    return {
      params: {
        businessLicense: []
      },
      form: {
        id: undefined,
        content: '',
        title: '',
        img: '',
        type: ''
      },

      type: {
        options: [
          { value: 1, label: this.$t('mes.system') },
          { value: 2, label: this.$t('mes.personal') }
        ]
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
     * 查询系统消息
     */
    findById(id) {
      find(id).then(response => {
        this.form.content = response.message.content
        this.form.title = response.message.title
        this.form.img = response.message.img
        this.form.type = response.message.type
      })
    },

    /**
     * 保存系统消息
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

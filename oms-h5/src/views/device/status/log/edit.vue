<template>
  <div class="app-container app-edit">
    <el-form class="small-space" :model="form" :rules="rules" ref="form" label-position="right" label-width="120px" style="width: 700px;">

      <!--  -->
      <el-form-item label="" prop="deviceId">
        <el-input v-model="form.deviceId" placeholder="请输入"></el-input>
      </el-form-item>

      <!-- 事件 -->
      <el-form-item label="事件" prop="type">
        <el-input v-model="form.type" placeholder="请输入事件"></el-input>
      </el-form-item>

      <!-- 设备上下线时间 -->
      <el-form-item label="设备上下线时间" prop="time">
        <el-input v-model="form.time" placeholder="请输入设备上下线时间"></el-input>
      </el-form-item>

      <el-form-item>
        <el-button type="primary" :loading="onSubmit" @click="handleSave">保存</el-button>
        <el-button @click="handleCancel">取消</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
import { find, save } from '@/api//device/status/log'

export default {
  data() {
    return {
      form: {
        id: undefined,
        deviceId: '',
        type: '',
        time: ''
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
     * 查询设备上下线记录
     */
    findById(id) {
      find(id).then(response => {
        this.form.deviceId = response.deviceStatusLog.deviceId
        this.form.type = response.deviceStatusLog.type
        this.form.time = response.deviceStatusLog.time
      })
    },

    /**
     * 保存设备上下线记录
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

<template>
  <div class="app-container app-edit">
    <el-form class="small-space" :model="form" :rules="rules" ref="form" label-position="right" label-width="120px" style="width: 700px;">

      <!-- 版本号 -->
      <el-form-item label="版本号" prop="revision">
        <el-input v-model="form.revision" placeholder="请输入版本号"></el-input>
      </el-form-item>

      <!-- 文本名称 -->
      <el-form-item label="文本名称" prop="name">
        <el-input v-model="form.name" placeholder="请输入文本名称"></el-input>
      </el-form-item>

      <el-form-item label="上传文件">
        <el-upload
        class="upload-demo"
        action="/api/uploadFiles"
        :on-success="handleSuccess"
        :on-error="handleError">
        <el-button size="small" type="primary">点击上传</el-button>
        <div slot="tip" class="el-upload__tip">只能上传固件升级文件</div>
      </el-upload>

        <!-- <el-upload action="/api/uploadFiles" list-type="picture-card" 
        :on-preview="handlePictureCardPreview" 
        :on-remove="handleRemove">
          <i class="el-icon-plus"></i>
        </el-upload>
        <el-dialog v-model="dialogVisible" size="tiny">
          <img width="100%" :src="dialogImageUrl" alt="">
        </el-dialog> -->
      </el-form-item>


      <!-- 设备类型 -->
      <el-form-item label="设备类型" prop="chipType">
        <!-- <el-input v-model="form.chipType" placeholder="请输入设备类型"></el-input> -->
        <el-select v-model="form.chipType" style="width: 120px" class="filter-item" clearable placeholder="设备类型">
          <el-option v-for="item in chip.type"
            :key="item.value"
            :label="item.label"
            :value="item.value">
          </el-option>
        </el-select>
      </el-form-item>


      <!-- 升级状态 -->
      <el-form-item label="升级状态" prop="type">
        <!-- <el-input v-model="form.type" placeholder="请输入升级状态"></el-input> -->
           <el-select v-model="form.type" style="width: 120px" class="filter-item" clearable placeholder="升级状态">
      <el-option v-for="item in type.options"
        :key="item.value"
        :label="item.label"
        :value="item.value">
      </el-option>
    </el-select>
        
      </el-form-item>

      <el-form-item>
        <el-button type="primary" :loading="onSubmit" @click="handleSave">保存</el-button>
        <el-button @click="handleCancel">取消</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
import { find, save } from '@/api//firmware'

export default {
  data() {
    return {
      fileList: [{ name: 'food.jpeg', url: 'https://fuss10.elemecdn.com/3/63/4e7f3a15429bfda99bce42a18cdd1jpeg.jpeg?imageMogr2/thumbnail/360x360/format/webp/quality/100'}, {name: 'food2.jpeg', url: 'https://fuss10.elemecdn.com/3/63/4e7f3a15429bfda99bce42a18cdd1jpeg.jpeg?imageMogr2/thumbnail/360x360/format/webp/quality/100'}],
      dialogImageUrl: '',
      dialogVisible: false,
      form: {
        id: undefined,
        revision: '',
        name: '',
        fileName: '',
        chipType: '',
        bytes: '',
        type: ''
      },

      chip: {
        type: [
          { value: 1, label: 'muc' },
          { value: 2, label: 'dsp' }
        ]
      },
      type: {
        options: [
          { value: 0, label: '不强制' },
          { value: 1, label: '强制' }
        ]
      },

      onSubmit: false,

      // 表单验证规则
      rules: {
        revision: [
          { required: true, message: '请输入版本号', trigger: 'blur' },
          { max: 50, message: '版本号不能超过50个字符', trigger: 'blur' }
        ],
        name: [
          { required: true, message: '请输入文本名称', trigger: 'blur' },
          { max: 50, message: '文本名称不能超过50个字符', trigger: 'blur' }
        ]/* ,
        chipType: [
          { required: true, message: '请选择设备类型', trigger: 'blur' }
        ],
        type: [
          { required: true, message: '请选择升级状态', trigger: 'blur' }
        ] */
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
     * 查询设备固件
     */
    findById(id) {
      find(id).then(response => {
        this.form.revision = response.firmware.revision
        this.form.name = response.firmware.name
        this.form.fileName = response.firmware.fileName
        this.form.chipType = response.firmware.chipType
        this.form.bytes = response.firmware.bytes
        this.form.type = response.firmware.type
      })
    },
    handleSuccess(response, file, fileList){
      var fName = response.fileName;
    
       console.log("fNAME:"+fName);
      this.form.fileName = fName;
      this.form.bytes = response.bytes;
        console.log(response);
    },
    handleError(err, file, fileList){

    },

    handlePictureCardPreview(file) {
      this.dialogImageUrl = file.url
      this.dialogVisible = true
    },
    /**
    /**
     * 保存设备固件
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

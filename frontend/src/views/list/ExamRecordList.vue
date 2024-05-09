<template>
  <div>
    <a-card style="margin-top: 24px" :bordered="false" title="参加过的考试">
      <div slot="extra">
        <a-input-search style="margin-left: 16px; width: 272px;"/>
      </div>
      <a-list size="large">
        <a-list-item :key="index" v-for="(item, index) in data">
          <a-list-item-meta :description="item.exam.examDescription">
            <a-avatar slot="avatar" size="large" shape="square" :src="item.exam.examAvatar | imgSrcFilter"/>
            <a slot="title">{{ item.exam.examName }}</a>
          </a-list-item-meta>
          <div slot="actions">
            <a @click="viewExamRecordDetail(item.examRecord)">查看考试详情</a>
            &nbsp;|&nbsp;
            <a @click="viewExamDelete(item.examRecord)">删除</a>
          </div>
          <div class="list-content">
            <div class="list-content-item">
              <span>Owner</span>
              <p>{{ item.user.userUsername }}</p>
            </div>
            <div class="list-content-item">
              <span>开始时间</span>
              <p>{{ item.examRecord.examJoinDate }}</p>
            </div>
            <div class="list-content-item">
              <span>分数</span>
              <p>{{ item.examRecord.examJoinScore }}</p>
            </div>
          </div>
        </a-list-item>
      </a-list>

    </a-card>
  </div>
</template>

<script>
import HeadInfo from '../../components/tools/HeadInfo'
import { getExamRecordList } from '../../api/exam'
import axios from 'axios'
import Swal from 'sweetalert2'

export default {
  // 考试记录列表，记录考生参加过地所有考试和考试成绩
  name: 'ExamRecordList',
  components: {
    HeadInfo
  },
  data () {
    return {
      data: {}
    }
  },
  methods: {
    /**
     * 根据考试记录的id拿到本次考试的详情并查看
     * @param record 考试详情的记录
     */
    viewExamRecordDetail (record) {
      // 直接跳到参加考试的页面，查看所有题目的详细情况
      const routeUrl = this.$router.resolve({
        path: `/exam/record/${record.examId}/${record.examRecordId}`
      })
      // 和点击考试卡片效果一样，跳转到考试页面，里面有所有题目的情况，相当于就是详情了
      window.open(routeUrl.href, '_blank')
    },
    /**
     * 根据考试记录的id删除选定的考试
     * @param examRecord 考试详情的记录
     */
    async viewExamDelete (examRecord) {
      const examId = examRecord.id
      // 异步确认
      const result = await Swal.fire({
        title: '确认删除',
        text: '您确定要删除此考试记录吗？',
        icon: 'warning',
        showCancelButton: true,
        confirmButtonText: '删除',
        cancelButtonText: '取消'
      })

      if (!result.isConfirmed) {
        return // 用户选择取消
      }

      this.isDeleting = true // 设置删除状态
      try {
        // 发送DELETE请求
        await axios.delete(`/api/exams/delete/${examId}`)

        // 更新组件数据
        this.examRecords = this.examRecords.filter(record => record.id !== examId)

        await Swal.fire({
          title: '删除成功',
          text: '考试记录已成功删除。',
          icon: 'success'
        })
      } catch (error) {
        console.error('删除失败:', error)

        await Swal.fire({
          title: '删除失败',
          text: '删除操作失败，请稍后再试。',
          icon: 'error'
        })
      } finally {
        this.isDeleting = false// 重置删除状态
      }
    }
  },
  mounted () {
    // 从后端数据获取考试列表，适配前端卡片
    getExamRecordList().then(res => {
      if (res.code === 0) {
        this.data = res.data
      } else {
        this.$notification.error({
          message: '获取考试记录失败',
          description: res.msg
        })
      }
    }).catch(err => {
      // 失败就弹出警告消息
      this.$notification.error({
        message: '获取考试记录失败',
        description: err.message
      })
    })
  }
}
</script>

<style lang="less" scoped>
  .ant-avatar-lg {
    width: 48px;
    height: 48px;
    line-height: 48px;
  }

  .list-content-item {
    color: rgba(0, 0, 0, .45);
    display: inline-block;
    vertical-align: middle;
    font-size: 14px;
    margin-left: 40px;

    span {
      line-height: 20px;
    }

    p {
      margin-top: 4px;
      margin-bottom: 0;
      line-height: 22px;
    }
  }
</style>

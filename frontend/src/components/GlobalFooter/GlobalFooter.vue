<template>
  <div class="footer">
    <div class="links">
      <a href="https://github.com/gpcpp" target="_blank">代码仓</a>
      <a href="mailto:tangtom608@gmail.com">联系我</a>
    </div>
  </div>
</template>

<script>
export default {
  name: 'GlobalFooter',
  data () {
    return {}
  }
}
</script>

<style lang="less" scoped>
.footer {
  padding: 0 16px;
  margin: 24px 0 24px;
  text-align: center;

  .links {
    margin-bottom: 20px;
    a {
      color: rgba(0, 0, 0, 0.45);
      &:hover {
        color: rgba(0, 0, 0, 0.65);
      }
      &:not(:last-child) {
        margin-right: 40px;
      }
    }
  }
}
</style>

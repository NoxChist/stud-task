<script>
export default {
  props:{
    title: {},
  }
}
</script>

<template>
  <h2 class="header-title">{{title}}</h2>
</template>

<style scoped>
.header-title {
  font-weight: 600;
  margin-bottom: 18px;
}
</style>
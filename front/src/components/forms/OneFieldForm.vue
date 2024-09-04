<script>
export default {
  data() {
    return {
      form: {
        name:null
      }
    }
  },
  props: {
    placeholder:String,
    buttonText:String
  },
  methods: {
    async submit() {
      if(this.form.name && this.form.name !=='') {
        this.$emit('submit', this.form)
        this.form.name = null;
      } else {
        alert(`Введите ${this.placeholder} в поле!`)
      }
    },
    rootPath() {
      console.log(this.$route.path)
      return this.$route.path ==="/"
    },
  }
}
</script>

<template>
  <div class="form">
    <input
        id="name"
        type="text"
        v-model="form.name"
        :placeholder="placeholder">
    <button @click="submit">
      {{ buttonText }}
    </button>
    <button v-show="!rootPath()" @click="this.$router.push('/')">
      К списку групп
    </button>
  </div>
</template>

<style scoped>
.form {
  display: flex;
  flex-direction: column;
  width: max-content;

}
.form > * {
  margin-top: 16px;
  font-size: 1em;
  line-height: 1.4em;
}
button {
  min-height: 1.6em;
}
</style>
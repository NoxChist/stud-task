<script>
import {getColumnSet} from "@/assets/js/utils.js";
import {GROUP_STUDENT_LIST, GROUP_TABLE} from "@/assets/js/dataType.js";

export default {
  data(){
    return {
      columnSet:[],
    }
  },
  props: {
    dataType: {
      required:true,
    },
    dataArray: {
      type:Array,
      required:true,
    },
    actionEnable: Boolean
  },
  methods: {
    remove(item){
      console.log("tray delete")
      console.log(item)
      this.$emit('remove', item)
    },
    push(el) {
      if(this.dataType === GROUP_TABLE)
      this.$router.push({
        path: `/${el.name}`,
        query: { id: el.id }
      });
    }

  },
  watch: {
    dataType(newValue) {
      this.columnSet = getColumnSet (newValue)
    }
  },
  mounted() {
    this.columnSet = getColumnSet (this.dataType)
  },
}
</script>

<template>
  <div class="table-box">

    <table v-show="dataArray">
      <tbody>
      <tr>
        <th v-for="col in columnSet"> {{col.title}}</th>
        <th v-show="actionEnable">Действие</th>
      </tr>
      <tr v-for="el in dataArray">
        <td @click="push(el)" v-for="col in columnSet"> {{ el[col.field] }}</td>
        <td class="action" @click="remove(el)" v-show="actionEnable"> &#128465; </td>
      </tr>
      </tbody>
    </table>

  </div>

</template>

<style scoped>
table {
  cursor: default;
}
table .action {
  cursor: pointer;
}

</style>
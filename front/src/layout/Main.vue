<script>
import Header from "@/components/Header.vue";
import TableComponent from "@/components/TableComponent.vue";
import OneFieldForm from "@/components/forms/OneFieldForm.vue";
import {dataFetchMixin} from "@/assets/js/fetchData.js";
import {VueAwesomePaginate} from "vue-awesome-paginate";
import {getColumnSet, getOneFieldFormProps} from "@/assets/js/utils.js";

export default {
  components: {VueAwesomePaginate, OneFieldForm, Header, TableComponent},
  mixins: [dataFetchMixin],
  data () {
    return {
      formTxt: getOneFieldFormProps(this.dataType),
      currentPage: 1,
      total: 10,
    }
  },
  props: {
    title: {
      type: String,
      required: true
    },
    dataType: {
      type: String,
      required: true
    },
    serviceType: {
      type: String,
      required: true
    },
    action: Boolean,
    pathPoint:{
      required:false
    }
  },
  methods: {
    submitHandler(fromForm) {
      this.add(fromForm)
    },
    onClickHandler(newPage) {
      this.currentPage = newPage;
      this.handlePageChange(newPage)
    },
  },
  watch: {
    dataType(newValue) {
      this.formTxt =  getOneFieldFormProps(newValue)
    },
    '$route'(to, from) {
      this.fetchData();
    },
  },

}
</script>

<template>
  <div class="container">
    <Header :title="title"/>
    <div v-if="size!==0" class="row g-0 pagi">
      <div class="pagi-info">
        {{currentPage}}/{{totalPages}} на странице {{size}}
      </div>
      <div v-if="size===0" class="pagi-info">
        Hа странице {{size}}
      </div>
      <vue-awesome-paginate
          v-if="size!==0"
          :total-items="totalPages"
          v-model="currentPage"
          :items-per-page="1"
          :max-pages-shown="1"
          :show-ending-buttons="false"
          :show-breakpoint-buttons="false"
          @click="onClickHandler" >
      </vue-awesome-paginate>
    </div>
    <TableComponent
        :data-array="list"
        :data-type="dataType"
        :key="list"
        :action-enable="action"
        @remove="remove"
    />
    <one-field-form
        :placeholder="formTxt.placeholder"
        :button-text="formTxt.buttonTxt"
        :key="dataType"
        @submit="submitHandler"/>
  </div>
</template>

<style scoped>
.container {
  width: 100%;
  display: flex;
  flex-direction: column;
  padding: 5%;
}
ul {
  list-style-type: none;
}


</style>
import STService from "@/service/service.js";
import {GROUP_TABLE, GROUP_STUDENT_LIST} from "@/assets/js/dataType.js"
import {HttpStatusCode} from "axios";

export const dataFetchMixin = {
    data() {
        return {
            list: [],
            size: 0,
            totalPages: 0,
            service: null,
            temp:null
        };
    },
    methods: {
        async fetchData(page) {
            const service = STService.getService(this.serviceType);
            if(this.pathPoint){
                service.setExtraPoint(this.pathPoint)
            }
            service.get(page).then(data => {
                this.list = data.content;
                this.size = data.numberOfElements.valueOf();
                this.totalPages = data.totalPages.valueOf();
            })
        },
        async add(fromForm) {
            const service = STService.getService(this.serviceType);
            if(this.dataType === GROUP_STUDENT_LIST){
                fromForm.group = this.$route.query.id
            }
            const item = (await service.add(fromForm)).data;
            if(this.dataType === GROUP_TABLE){
                const groupName = item.name;
                this.$router.push({
                    path: `/${groupName}`,
                    query: { id: item.id }
                });
            } else {
                this.fetchData( 0);
            }
        },
        async remove(item) {
            const service = STService.getService(this.serviceType);
            const response = await service.delete(item)
            if(response.status === HttpStatusCode.Ok){
                alert( "Element was deleted")
                this.fetchData(0)
            }
        },

        handlePageChange(newPage) {
            this.fetchData(newPage - 1);
        },
    },
    created() {
        if (this.serviceType) {
            this.fetchData( 0);
        } else {
            console.error("Service name is not provided");
        }
    },
};
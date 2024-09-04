import axios from 'axios';
import {GROUP_S, STUD_S} from "@/service/serviseType.js"

const API_URL = 'http://localhost:8080';
const ADD_URL = '/create';
const apiClient = axios.create({
    baseURL: API_URL,
    withCredentials: false,
    headers: {
        'Content-Type': 'application/json',
        'Accept': 'application/json',
    }
});
class BaseService {
    constructor(basePath) {
        this.baseUrl = `${API_URL}${basePath}`;
    }

    setExtraPoint(point) {
        this.baseUrl = `${this.baseUrl}/${point}`
    }

    async get(page = 0) {
        try {
            const response = await apiClient.get(this.baseUrl, {params: {
                    page: page
                }});
            return response.data;
        } catch (error) {
            this.handleError('Error fetching data:', error);
        }
    }

    async add(formData) {
        try {
            return await apiClient.post(`${this.baseUrl}${ADD_URL}`, formData);
        } catch (error) {
            this.handleError('Error adding element:', error);
        }
    }

    async delete(item) {
        const json = JSON.stringify(item)
        try {
            return await apiClient.delete(this.baseUrl, {
                data: json,
            });

        } catch (error) {
            this.handleError('Error removing element:', error);
        }
    }

    handleError(message, error) {
        console.error(message, error);
    }

}

class StudentService extends BaseService {
    constructor() {
        super('/student');
    }
}
class GroupService extends BaseService {
    constructor() {
        super('/group');
    }
}
class STService {
    static getService(serviceType) {
        switch (serviceType) {
            case GROUP_S:
                return new GroupService();
            case STUD_S:
                return new StudentService();
            default:
                throw new Error('Unknown service type');
        }
    }
}

export default STService;
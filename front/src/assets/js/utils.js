import {GROUP_STUDENT_LIST, GROUP_TABLE} from "@/assets/js/dataType.js"

const groupCommonDataSet = [
    { title: "Номер", field: 'name' },
    { title: "Количество студентов", field: 'students' },
]
const groupStudentsDataSet = [
    { title: "Дата принятия", field: 'dateAdmission' },
    { title: "ФИО студента", field: 'name' },
]

const formAddGroup = {
    placeholder:"Номер группы",
    buttonTxt:"Добавить новую группу"
}
const formAddStudent = {
    placeholder:"ФИО",
    buttonTxt:"Принять нового студента"
}


export function getColumnSet (dataType) {
    switch (dataType) {
        case GROUP_TABLE:
            return groupCommonDataSet;
        case GROUP_STUDENT_LIST:
            return groupStudentsDataSet;
        default :
            return null;
    }
}
export function getOneFieldFormProps (dataType) {
    switch (dataType) {
        case GROUP_TABLE:
            return formAddGroup;
        case GROUP_STUDENT_LIST:
            return formAddStudent;
        default :
            return null;
    }
}
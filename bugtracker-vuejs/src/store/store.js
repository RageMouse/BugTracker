import Vue from 'vue'
import Vuex from 'vuex'
import axios from "axios";


Vue.use(Vuex);

export const store = new Vuex.Store({
    state: {
        projects: {},
        project: {
            projectid: '',
            projectName: '',
            projectDescription: '',
            active: true
        },
        bugs: {}
    },
    getters: {
        projects(state){
            return state.projects
        },
        project(state){
            return state.project
        },
        bugs(state){
            return state.bugs
        }
    },
    actions: {
        getAllProjects(context) {
            return axios
                .get("http://192.168.99.100:8008/project/")
                .then((response) => {
                    context.commit("setProjects", response.data);
                })
                .catch(error => {
                    throw new Error(error)
                });
        },
        createProject(context, data){
            return axios
                .post("http://192.168.99.100:8008/project/", {
                    projectName: data.projectName,
                    projectDescription: data.projectDescription,
                    active: data.active
                })
                .then(({data}) => {
                    context.commit("addProject", data)
                  }).catch((error) => {
                    throw error
                  })
        },
        getProject(context, id) {
            return axios
                .get("http://192.168.99.100:8008/project/" + id)
                .then((response) => {
                    context.commit("setProject", response.data);
                })
                .catch(error => {
                    throw new Error(error)
                });
        },
        editProject(context, data) {
            return axios
                .put("http://192.168.99.100:8008/project/", {
                    projectId: data.projectId,
                    projectName: data.projectName,
                    projectDescription: data.projectDescription,
                })
                .then((response) => {
                    context.commit("setProject", response.data);
                })
                .catch(error => {
                    throw new Error(error)
                });
        },
        getBugs(context, id) {
            return axios
                .get("http://192.168.99.100:8008/bug/" + id)
                .then((response) => {
                    context.commit("setBugs", response.data);
                })
                .catch(error => {
                    throw new Error(error)
                });
        },
        submitBug(context, data){
            return axios
                .post("http://192.168.99.100:8008/bug/", {
                    bugTitle: data.bugTitle,
                    bugDescription: data.bugDescription,
                    solved: data.solved,
                    projectId: data.projectId
                })
                .then(({data}) => {
                    context.commit("addBug", data)
                  }).catch((error) => {
                    throw error
                  })
        },
    },
    mutations: {
        setProjects(state, projects){
            state.projects = projects;
        },
        setProject(state, project){
            state.project = project;
        },
        addProject(state, project){
            state.projects.push(project)
        },
        setBugs(state, bugs){
            state.bugs = bugs;
        },
        addBug(state, bug){
            state.bugs.push(bug)
        },
    }
});
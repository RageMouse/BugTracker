import Vue from 'vue'
import Vuex from 'vuex'
import axios from "axios";


Vue.use(Vuex);

export const store = new Vuex.Store({
    state: {
        projects: {},
        project: {
            projectName: '',
            projectDescription: '',
            active: true
        }
    },
    getters: {
        projects(state){
            return state.projects
        },
        project(state){
            return state.project
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
                    context.commit("setProject", data);
                  }).catch((error) => {
                    throw error
                  })
        }
    },
    mutations: {
        setProjects(state, projects){
            state.projects = projects;
        },
        setProject(state, project){
            state.project = project;
        }
    }
});
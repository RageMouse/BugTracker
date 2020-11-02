import Vue from 'vue'
import Vuex from 'vuex'
import axios from "axios";


Vue.use(Vuex);

export const store = new Vuex.Store({
    state: {
        projects: []
    },
    getters: {
        projects(state){
            return state.projects
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
        }
    },
    mutations: {
        setProjects(state, projects){
            state.projects = projects;
        }
    }
});
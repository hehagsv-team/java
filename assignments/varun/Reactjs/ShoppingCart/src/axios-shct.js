import axios from 'axios';

const instance = axios.create({
    baseURL: 'https://react-my-burger-6ce77.firebaseio.com/',
    withCredentials: false,
  headers: {
    'Access-Control-Allow-Origin' : '*',
    'Access-Control-Allow-Methods':'GET,PUT,POST,DELETE,PATCH,OPTIONS',
    }
});

export default instance;
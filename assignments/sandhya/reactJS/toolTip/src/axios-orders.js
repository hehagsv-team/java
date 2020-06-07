import axios from 'axios';

const instance = axios.create({
    baseURL: 'https://react-burger-8bb26.firebaseio.com/'
});

export default instance;
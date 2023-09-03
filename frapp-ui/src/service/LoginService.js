import axios from "axios";

const FRAPP_BASE_URL="http://localhost:8081/api/portal/users/login"


class LoginService{
    loginUser(userLoginModel){
    return axios.post(FRAPP_BASE_URL,userLoginModel)
    }
}
export default new LoginService();
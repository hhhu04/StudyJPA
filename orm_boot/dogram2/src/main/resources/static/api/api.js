import { sendRequest, sendRequestFormData } from "/lib/ajax.js";

class API {
  // getTodoList() {
  //   let url = "/api/todolist";
  //   let response = sendRequest("GET", url);

  //   return response;
  // }
  async getUserimg() {
    // let url =
    //   "http://api.openweathermap.org/data/2.5/weather?q=seoul&appid=a73a95d23aafd36d49c370750d7a2781";
    let url = "http://jsonplaceholder.typicode.com/todos/1";
    let response = await sendRequest("GET", url);

    return response;
  }
  async postUpload(formData) {
   // let url = "http://101.101.211.145:8080/feed/newfeed";
    let url = "http://localhost:8080/feed/newFeed";
    let response = await sendRequestFormData("POST", url, formData);

    return response;
  }
  async postJoin(formData) {
   // let url = "http://101.101.211.145:8080/user/join2";
    let url = "http://localhost:8080/user/join2";
    let response = await sendRequestFormData("POST", url, formData);

    return response;
  }
  async postComment(formData) {
    // let url = "http://101.101.211.145:8080/feed/commentadd";
    let url = "http://localhost:8080/feed/commentadd";

    let response = await sendRequest("POST", url, formData);
    console.log(response);

    return response;
  }
  async postLogin(data) {
   // let url = "http://101.101.211.145:8080/user/login";
    let url = "http://localhost:8080/user/login";

    let response = await sendRequest("POST", url, data);
    console.log(response);

    return response;
  }
  async deleteComment(data) {
  //  let url = "http://101.101.211.145:8080/feed/commentdel";
    let url = "http://localhost:8080/feed/commentdel";

    // let url = "http://101.101.211.145:8080/feed/commentdel";
    let response = await sendRequest("POST", url, data);
    console.log(response);

    return response;
  }
  async getFirstFeedLoad() {
   // let url = "http://101.101.211.145:8080/feed/";
     let url = "http://localhost:8080/feed/";
    // let url = "http://127.0.0.1:5501/data/status.json";
    let response = await sendRequest("POST", url);
    console.log(response);
    // console.log(
    //   response.then((data) => {
    //     return data;
    //   })
    // );
    console.log("api call");
    return response;
  }

  async getMyFeedList() {
    // let url = "http://101.101.211.145:8080/user/feedList";
    let url = "http://localhost:8080/user/feedList";
    let response = await sendRequest("POST", url);
    return response;
  }
  async deleteUser() {
   // let url = "http://101.101.211.145:8080/user/delete";
    let url = "http://localhost:8080/user/delete";
    let response = await sendRequest("POST", url);
    console.log("api call");
    return response;
  }

  async addLike(data) {
     let url = "http://localhost:8080/feed/addlike";
   // let url = "http://101.101.211.145:8080/feed/addlike";

    let response = await sendRequest("POST", url, data);
    console.log("api call");
    return response;
  }
}

export default API;

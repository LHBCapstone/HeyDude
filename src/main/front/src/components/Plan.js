import React from "react";
import Button from 'react-bootstrap/Button';
import axios from "axios";
import { useState } from "react";


function Plan() {
  const [message, setMessage] = useState("");
  const sayhi = async()=>{
  
  axios.get("/user/test", {params:{say:"hi"}}).then(res => {
        console.log(res.data);
        setMessage(res.data);
  }).catch((error)=>{console.log("오류")});
}
  return (
    <div>
      <h1>플랜</h1>
      <Button variant="success" onClick={sayhi}>button</Button>
      {message}
    </div>
  );
}

export default Plan;

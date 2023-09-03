import React,{useState} from 'react';
import { Container, Row, Col, Card, Form, Button, Image } from 'react-bootstrap';
import 'animate.css';
import LoginService from "../service/LoginService";


function Login() {
       //TODO: Create data models and Route System.
   const [user, setUser]= useState({
    userName:"",
    password:""

   });

    const handleChange = (e) => {
      const { name, value } = e.target;
      setUser((prevUser) => ({
        ...prevUser,
        [name]: value,
      }));
    };

    const userLogin = (e)=>{
    e.preventDefault();
    LoginService.loginUser(user)
    .then((response)=>{
    console.log(response)
    }).catch((error)=>{
    console.log(error)
    });
    };
  return (
      <Row className="fluid">
        <Col className="container-fluid">
          <Image className="animate__animated animate__bounce vh-100 w-100" src="./img/loginpage.jpg" alt="Resim Açıklaması" fluid />
        </Col>
        <Col>
          <Row>
              <Card className="vh-100">
                <Card.Body>
                  <div className="mt-5">
                    <h2 className="fw-bold mb-2 text-uppercase text-primary">FRAPP</h2>
                    <p className=" mb-5">Please enter your login and password!</p>
                    <div id="logg" className="mb-3">
                      <Form className="w-75 ">
                        <Form.Group className="mb-3" controlId="formBasicEmail">
                          <Form.Label className="text-center">
                            User Name
                          </Form.Label>
                          <Form.Control
                          name="userName"
                            value={user.userName}
                            onChange={(e) => handleChange(e)}
                            type="input"
                            placeholder="Enter email" />
                        </Form.Group>

                        <Form.Group
                          className="mb-3"
                          controlId="formBasicPassword"
                        >
                          <Form.Label>Password</Form.Label>
                          <Form.Control
                            name="password"
                            value={user.password}
                            onChange={(e) => handleChange(e)}
                            type="password"
                            placeholder="Password"
                            />
                        </Form.Group>
                        <Form.Group
                          className="mb-3"
                          controlId="formBasicCheckbox"
                        >
                          <p className="small">
                            <a className="text-primary" href="#!">
                              Forgot password?
                            </a>
                          </p>
                        </Form.Group>
                        <div className="d-grid">
                          <Button
                           onClick={userLogin}
                           variant="primary" type="submit">
                            Login
                          </Button>
                        </div>
                      </Form>
                      <div className="mt-3">
                        <p className="mb-0  text-center">
                          Don't have an account?{" "}
                          <a href="{''}" className="text-primary fw-bold">
                            Sign Up
                          </a>
                        </p>
                      </div>
                    </div>
                  </div>
                </Card.Body>
              </Card>

          </Row>
        </Col>
      </Row>
  );
}

export { Login };
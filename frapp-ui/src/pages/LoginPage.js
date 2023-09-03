import React from 'react';
import { Container, Row, Col, Card, Form, Button, Image } from 'react-bootstrap';

function Login() {
  return (
      <Row className="container-fluid">
        <Col className="container-fluid m-4">
          <Image className="vh-100 w-100" src="./img/loginpage.jpg" alt="Resim Açıklaması" fluid />
        </Col>
        <Col>
          <Row className="vh-100 align-items-center">
              <div className="container-fluid border border-3 border-primary"></div>
              <Card className="shadow">
                <Card.Body container-fluid>
                  <div className="mb-3 mt-md-4">
                    <h2 className="fw-bold mb-2 text-uppercase align-item-center ">FRAPP</h2>
                    <p className=" mb-5">Please enter your login and password!</p>
                    <div id="logg" className="mb-3">
                      <Form>
                        <Form.Group className="mb-3" controlId="formBasicEmail">
                          <Form.Label className="text-center">
                            User Name
                          </Form.Label>
                          <Form.Control type="input" placeholder="Enter email" />
                        </Form.Group>

                        <Form.Group
                          className="mb-3"
                          controlId="formBasicPassword"
                        >
                          <Form.Label>Password</Form.Label>
                          <Form.Control type="password" placeholder="Password" />
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
                          <Button variant="primary" type="submit">
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
import React, { useState } from 'react';
import Button from 'react-bootstrap/Button';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';
import { Container } from 'react-bootstrap';
import GenerateSchedule from './GenerateSchedule';
import AdminViewRoute from './AdminViewRoute';
import AdminViewTrain from './AdminViewTrain';
import AdminViewFare from './AdminViewFare';


function AdminMainScreen() {
  const [showSchedule, setShowSchedule] = useState(false);
  const [showRoute, setShowRoute] = useState(false);
  const [showTrain, setShowTrain] = useState(false);
  const [showFare, setShowFare] = useState(false);

  function handleScheduleClick() {
    setShowSchedule(true);
    setShowRoute(false);
    setShowTrain(false);
    setShowFare(false);
  }

  function handleRouteClick() {
    setShowSchedule(false);
    setShowRoute(true);
    setShowTrain(false);
    setShowFare(false);
  }

  function handleTrainClick() {
    setShowSchedule(false);
    setShowRoute(false);
    setShowTrain(true);
    setShowFare(false);
  }

  function handleFareClick() {
    setShowSchedule(false);
    setShowRoute(false);
    setShowTrain(false);
    setShowFare(true);
  }

  return (
    <div>
      <Container>
        <Row>
          <Col>
            <Button onClick={handleTrainClick} variant="outline-secondary">
              <p>VIEW TRAINS</p>
            </Button>
          </Col>
          <Col>
            <Button onClick={handleRouteClick} variant="outline-secondary">
              <p>VIEW ROUTES</p>
            </Button>
          </Col>
        </Row>
        <Row>
          <Col>
            <Button onClick={handleFareClick} variant="outline-secondary">

              <img src="https://source.unsplash.com/500x200/?train" alt="Button 3" />
              <p>VIEW FARE</p>
            </Button>
          </Col>
          <Col>
            <Button onClick={handleScheduleClick} variant="outline-secondary">
              <p>VIEW TRAIN SCHEDULES</p>
            </Button>
          </Col>
        </Row>
        {showTrain && <AdminViewTrain />}
        {showFare && <AdminViewFare />}
        {showRoute && <AdminViewRoute />}
        {showSchedule && <GenerateSchedule />}
      </Container>
    </div>
  );
}

export default AdminMainScreen;

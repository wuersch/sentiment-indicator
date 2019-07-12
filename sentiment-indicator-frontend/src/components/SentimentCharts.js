import React from 'react';

import { Container, Row, Col } from 'react-bootstrap';
import GaugeChart from 'react-gauge-chart';

class SentimentCharts extends React.Component {
  constructor(props) {
    super(props);
    this.state = { votes: [] }
  }

  componentDidMount() {
    fetch('http://localhost:8080/votes')
      .then(response => response.json())
      .then(data => {
        this.setState({
          votes: data
        });
      });
  }

  render() {
    return (
      <Container fluid={false} className="center">
        <Row>
          {
            this.state.votes.map((vote, index) => {
              return (
                <ChartCol key={index} businessUnit={vote.businessUnit} avg={vote.avg} />
              )
            })
          }
        </Row>
      </Container>
    );
  }
}

const ChartCol = (vote) => (
  <Col md={5}>
    <h5>{vote.businessUnit}</h5>
    <GaugeChart id={vote.businessUnit} nrOfLevels={20} colors={["#f03d07", "#afeb0c"]} percent={vote.avg / 10} />
  </Col>
);

export default SentimentCharts;
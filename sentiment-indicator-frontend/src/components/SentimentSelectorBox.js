import React from 'react';

import smiley_happy from '../images/happy.svg';
import smiley_unhappy from '../images/unhappy.svg';

const SentimentSelectorBox = (props) => (
  <div>
    <div className="SentimentSelectorBox center">
      <Smiley src={smiley_unhappy} alt="Unhappy Smiley" />
      <RadioButtonGroup history={props.history} />
      <Smiley src={smiley_happy} alt="Happy Smiley" />
    </div>
  </div>
);

const Smiley = (props) => (
  <img src={props.src} className="Smiley" alt={props.alt} />
);

const RadioButtonGroup = (props) => (
  <div className="RadioButtonGroup">
    {
      [...Array(10)].map((e, index) => <RadioButton key={index} history={props.history} label={index + 1} />)
    }
  </div>
);

class RadioButton extends React.Component {
  handleClick = () => {
    fetch("http://localhost:8080/votes",
      {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify({
          item: this.props.label,
          user: '0007',
          businessUnit: 'IXI',
          timeOfVoting: Math.floor(Date.now())
        })
      }
    ).then(response => {
      if (response.status === 201) {
        this.props.history.push('/charts')
      }
    });
  }

  render() {
    return (
      <div className="RadioButton">
        <input
          type="radio"
          name="sentiment"
          value="{this.props.label}"
          onClick={() => this.handleClick()}
        />
        <label>{this.props.label}</label>
      </div>
    );
  }
}

export default SentimentSelectorBox;
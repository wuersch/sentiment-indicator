import React from 'react';
import { BrowserRouter as Router, Route, Redirect, Switch } from 'react-router-dom';

import SentimentSelectorBox from './SentimentSelectorBox.js';
import SentimentCharts from './SentimentCharts.js';

const AppRouter = () => (
  <Router>
    <Switch>
      <Route exact path="/" render={() => (
        <Redirect to="/votes" />)} />
      <Route path="/votes" component={SentimentSelectorBox} />
      <Route path="/charts" component={SentimentCharts} />
    </Switch>
  </Router>
);

export default AppRouter;
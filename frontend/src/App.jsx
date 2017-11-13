import React from 'react';
import ReactDOM from 'react-dom';
import {Main} from './views/Main';
import { data } from './middleware/Store';

ReactDOM.render(<Main data={data}/>, document.getElementById('app'));
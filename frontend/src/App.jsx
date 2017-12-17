import React from 'react';
import ReactDOM from 'react-dom';
import {Main} from './views/Main';
import { data } from './middleware/Store';

import { combineReducers, createStore } from 'redux';
import * as ActionTypes from './constants/ActionTypes';
import { Provider } from 'react-redux';
import * as reducers from './reducers';

import { BrowserRouter } from 'react-router-dom';

const reducer = combineReducers(reducers);
// const store = createStore((state, action) => { return { posts: { posts: [], postsById: {}}} ; });
const store = createStore(reducer);

fetch("http://localhost:8080/posts", {
    // mode: 'no-cors',
    method: "GET",
    headers: {
        "Accept": "application/json"
    }
})
    .then(res => {
        return res.json();
    })
    .then(text => {
        store.dispatch({
            type: ActionTypes.ADD_POSTS,
            data: text
        });
    });



class App extends React.Component {
    constructor(props){
        super(props);
    }
    render() {
        return (
            <BrowserRouter>
                <div>
                    <Provider store={store}>
                        <Main/>
                    </Provider>
                </div>
            </BrowserRouter>

        );
    }
};


ReactDOM.render(<App/>, document.getElementById('app'));
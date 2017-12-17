import { bindActionCreators } from 'redux';
import { connect } from 'react-redux';
import * as PostActions from "../actions/PostActions";

import React from 'react';
import { Grid } from './Grid';

import { Route, Switch } from 'react-router-dom';

@connect(state => ({data: state.posts}))
export class Main extends React.Component {
    constructor(props) {
        super(props);
    }

    render() {
        // this.props = { data: {...SOME_OBJECT...}, dispatch, ...... ,..... ,.....}
        // const [firstElem , secondElem] = this.props;
        const { data: { posts }, dispatch } = this.props;
        const actions = bindActionCreators(PostActions, dispatch);

        return (
            <Switch>
                <Route path="/" render={() => <Grid cards={posts} action={actions}/>}/>
            </Switch>
        );
    }
}

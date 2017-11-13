import React from 'react';
import { Grid } from './Grid';

export class Main extends React.Component {
    constructor(props) {
        super(props);
    }

    render() {
        return (
            <Grid cards={this.props.data}/>
        );
    }
}

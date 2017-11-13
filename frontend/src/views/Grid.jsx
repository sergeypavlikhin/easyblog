import React from 'react';
import {Card} from './Card';
import { Grid as SemGrid} from 'semantic-ui-react';

export class Grid extends React.Component {
    constructor(props) {
        super(props);
    }

    render() {
        let cards = this.props.cards.map((item) => <Card key={item.id} {...item}/>);
        return ( <SemGrid centered columns={2}>
                    <SemGrid.Column>
                        {cards}
                    </SemGrid.Column>
                </SemGrid>);
    }
}
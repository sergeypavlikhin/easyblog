import React from 'react';
import { Card as SemCard, Icon } from 'semantic-ui-react';
import moment from 'moment';

export class Card extends React.Component {
    constructor(props) {
        super(props);
    }

    handleRemove = (id) => {
        this.props.removePost(id);
    };

    render() {
        return (<SemCard fluid>
                    <SemCard.Content>
                        <SemCard.Header>
                            {this.props.title}
                        </SemCard.Header>
                        <SemCard.Meta>
                            <span className='date'>
                                 { moment(this.props.date_created, "x").format("DD MMM YYYY") }
                            </span>
                        </SemCard.Meta>
                        <SemCard.Description>
                            {this.props.description}
                        </SemCard.Description>
                    </SemCard.Content>
                    <SemCard.Content extra>
                        <a onClick={() => this.handleRemove(this.props.id) }>
                            <Icon name='user' />
                            22 Cards
                        </a>
                    </SemCard.Content>
                </SemCard>
        );
    }

}
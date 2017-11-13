import React from 'react';
import { Card as SemCard, Icon } from 'semantic-ui-react';

export class Card extends React.Component {
    constructor(props) {
        super(props);
    }

    render() {
        return (<SemCard fluid>
                    <SemCard.Content>
                        <SemCard.Header>
                            {this.props.title}
                        </SemCard.Header>
                        <SemCard.Meta>
                            <span className='date'>
                                 {this.props.created}
                            </span>
                        </SemCard.Meta>
                        <SemCard.Description>
                            {this.props.description}
                        </SemCard.Description>
                    </SemCard.Content>
                    <SemCard.Content extra>
                        <a>
                            <Icon name='user' />
                            22 Friends
                        </a>
                    </SemCard.Content>
                </SemCard>
        );
    }

}
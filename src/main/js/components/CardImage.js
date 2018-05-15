import React, {Component} from 'react'
import {UNKNOWN_CARD_URL} from '../consts'


export default class CardImage extends Component {
    constructor(props) {
        super(props);
        this.state = {error: false};
    }

    static getDerivedStateFromProps(nextProps, prevState) {
        return {error: false};
    }

    render() {
        return (
            <img src={(!this.props.src || this.state.error) ? UNKNOWN_CARD_URL : this.props.src}
                 alt={this.props.name}
                 onError={() => this.setState({error: true})}
                 style={{width: 307, height: 456}}
            />
        )
    }
}
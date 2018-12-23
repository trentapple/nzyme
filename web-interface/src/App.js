import React from 'react';
import Reflux from 'reflux';

import {
    BrowserRouter as Router,
    Switch,
    Route
} from 'react-router-dom';

import Notifications from 'react-notify-toast';

import PingStore from "./stores/PingStore";
import PingActions from "./actions/PingActions";

import NavigationBar from './components/layout/NavigationBar';
import OverviewPage from "./components/overview/OverviewPage";
import NotConnectedPage from "./components/misc/NotConnectedPage";
import NotFoundPage from "./components/misc/NotFoundPage";
import AlertDetailsPage from "./components/alerts/AlertDetailsPage";
import Routes from "./util/Routes";

class App extends Reflux.Component {

    constructor(props) {
        super(props);

        this.state = {
            apiConnected: true
        };

        this.store = PingStore;
    }

    componentDidMount() {
        PingActions.ping();
    }

    render() {
        if(this.state.apiConnected) {
            return (
                <Router>
                    <div className="nzyme">
                        <NavigationBar/>

                        <div className="container">
                            <Notifications/>

                            <Switch>
                                <Route exact path={Routes.DASHBOARD} component={OverviewPage} />

                                { /* Alerts. */ }
                                <Route path={Routes.ALERTS.SHOW(":id")} component={AlertDetailsPage} />

                                { /* 404. */ }
                                <Route path={Routes.NOT_FOUND} component={NotFoundPage} />
                                <Route path="*" component={NotFoundPage} /> { /* Catch-all.  */ }
                            </Switch>
                        </div>
                    </div>
                </Router>
            );
        } else {
            return (
                <div className="nzyme">
                    <NavigationBar/>

                    <div className="container">
                        <Notifications />
                        <NotConnectedPage />
                    </div>
                </div>
            )
        }
    }
}

export default App;

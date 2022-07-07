import React from "react";
import numeral from "numeral";

function CaptureRow(props) {

    const c = props.capture;

    return (
        <tr>
            <td>{c.interface_name}</td>
            <td>{c.capture_type}</td>
            <td>{c.is_running ? "YES" : "NO"}</td>
            <td>{numeral(c.received).format("0,0")}</td>
            <td>{numeral(c.dropped_interface).format("0,0")}</td>
            <td>{numeral(c.dropped_buffer).format("0,0")}</td>
        </tr>
    )
}

export default CaptureRow;
/*
 * This file is part of nzyme.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the Server Side Public License, version 1,
 * as published by MongoDB, Inc.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * Server Side Public License for more details.
 *
 * You should have received a copy of the Server Side Public License
 * along with this program. If not, see
 * <http://www.mongodb.com/licensing/server-side-public-license>.
 */

package horse.wtf.nzyme.ethernet.dns.db;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DNSTrafficSummaryMapper implements RowMapper<DNSTrafficSummary> {

    @Override
    public DNSTrafficSummary map(ResultSet rs, StatementContext ctx) throws SQLException {
        return DNSTrafficSummary.create(
                rs.getLong("total_dns_packets"),
                rs.getLong("total_dns_traffic_bytes"),
                rs.getLong("nxdomain_count")
        );
    }

}

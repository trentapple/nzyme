/*
 *  This file is part of nzyme.
 *
 *  nzyme is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  nzyme is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with nzyme.  If not, see <http://www.gnu.org/licenses/>.
 */

package horse.wtf.nzyme.dot11.networks.beaconrate;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.auto.value.AutoValue;

import javax.annotation.Nullable;

@AutoValue
public abstract class BeaconRate {

    @Nullable
    @JsonProperty("rate")
    public abstract Float rate();

    @JsonProperty("in_training")
    public abstract boolean inTraining();

    public static BeaconRate create(Float rate, boolean inTraining) {
        return builder()
                .rate(rate)
                .inTraining(inTraining)
                .build();
    }

    public static Builder builder() {
        return new AutoValue_BeaconRate.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder rate(Float rate);

        public abstract Builder inTraining(boolean inTraining);

        public abstract BeaconRate build();
    }

}

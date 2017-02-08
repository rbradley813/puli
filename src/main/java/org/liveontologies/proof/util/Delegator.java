/*-
 * #%L
 * Proof Utility Library
 * $Id:$
 * $HeadURL:$
 * %%
 * Copyright (C) 2014 - 2017 Live Ontologies Project
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
package org.liveontologies.proof.util;

/**
 * A prototype that can be used for delegating method calls to a provided
 * delegate object. Instances of this class are compared by comparing the
 * corresponding delegate objects.
 * 
 * 
 * @author Yevgeny Kazakov
 *
 * @param <D>
 */
public class Delegator<D> {

	private final D delegate_;

	Delegator(D delegate) {
		Util.checkNotNull(delegate);
		this.delegate_ = delegate;
	}

	public final D getDelegate() {
		return delegate_;
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof Delegator<?>) {
			return delegate_.equals(((Delegator<?>) o).delegate_);
		}
		// else
		return false;
	}

	@Override
	public int hashCode() {
		return delegate_.hashCode();
	}

	@Override
	public String toString() {
		return delegate_.toString();
	}

}

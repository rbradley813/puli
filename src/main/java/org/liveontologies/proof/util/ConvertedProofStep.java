package org.liveontologies.proof.util;

/*-
 * #%L
 * OWL API Proof Extension
 * $Id:$
 * $HeadURL:$
 * %%
 * Copyright (C) 2014 - 2016 Live Ontologies Project
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

import java.util.AbstractList;
import java.util.List;

public class ConvertedProofStep<C> extends DelegatingProofStep<C> {

	protected ConvertedProofStep(ProofStep<C> delegate) {
		super(delegate);
	}

	@Override
	public List<ProofNode<C>> getPremises() {
		final List<? extends ProofNode<C>> original = super.getPremises();
		return new AbstractList<ProofNode<C>>() {

			@Override
			public ProofNode<C> get(int index) {
				return convert(original.get(index));
			}

			@Override
			public int size() {
				return original.size();
			}
		};
	}

	@Override
	public ProofNode<C> getConclusion() {
		return convert(super.getConclusion());
	}

	protected ConvertedProofNode<C> convert(ProofNode<C> node) {
		return new ConvertedProofNode<C>(node);
	}

}

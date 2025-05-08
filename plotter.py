import json
import matplotlib.pyplot as plt
import numpy as np
from typing import List, Dict

COLORS = {
    "25": '#1f77b4',
    "50": '#ff7f0e',
    "500": '#2ca02c',
    "1000": '#d62728'
}

def load_jmh_results(filepath: str) -> List[Dict]:
    with open(filepath, 'r') as file:
        return json.load(file)

def plot_jmh_results(data: List[Dict], name: str):
    benchmark_groups = {}

    for entry in data:
        benchmark_name = entry['benchmark']
        score = entry['primaryMetric']['score']
        error = entry['primaryMetric']['scoreError']
        params = entry.get('params', {})
        precision = params.get('precision', 'default')

        if benchmark_name not in benchmark_groups:
            benchmark_groups[benchmark_name] = []
        benchmark_groups[benchmark_name].append((precision, score, error))

    fig, ax = plt.subplots(figsize=(12, 6))
    bar_width = 0.25
    group_offset = 0
    ytick_positions = []
    ytick_labels = []

    for i, (benchmark_name, param_data) in enumerate(benchmark_groups.items()):
        x_pos = np.arange(len(param_data)) + group_offset
        precisions, scores, errors = zip(*param_data)

        for j, (precision, score, error) in enumerate(param_data):
            color = COLORS.get(str(precision), '#cccccc')
            ax.barh(group_offset + j, score, height=bar_width, color=color, alpha=0.8)
            ax.errorbar(score, group_offset + j, xerr=error * 0.1, capsize=2, fmt='none', ecolor='#ff7777', elinewidth=0.5)
            ax.text(score + 0.01, group_offset + j, f'{precision}', va='center', fontsize=9)

        ytick_positions.append(group_offset + len(param_data) / 2 - 0.5)
        ytick_labels.append(benchmark_name.split('.')[-1])
        group_offset += len(param_data) + 1

    ax.tick_params(axis='x', labelsize=12) 
    ax.set_yticks(ytick_positions)
    ax.set_yticklabels(ytick_labels, fontsize=9, rotation=45, ha='right')
    ax.set_xlabel('Score [ns/op] (lower is better)', fontsize=12)
    ax.set_title(f'Apfloat v BigDecimal benchmark: {name}', fontsize=14)
    ax.grid(axis='x', linestyle='--', alpha=0.7)

    legend_labels = [f'{p}' for p in COLORS.keys()]
    legend_colors = [COLORS[p] for p in COLORS.keys()]
    from matplotlib.patches import Patch
    legend_patches = [Patch(color=color, label=label) for color, label in zip(legend_colors, legend_labels)]
    ax.legend(handles=legend_patches, fontsize=10, title='Precisions')

    plt.tight_layout(pad=3.5)
    output_filename = filepath.replace('.json', '.svg')
    plt.savefig(output_filename, format='svg')
    print(f"Plot saved to {output_filename}")

if __name__ == "__main__":
    import sys
    if len(sys.argv) != 2:
        print("Usage: python plotter.py <plot-name>")
        print("   <plot-name> is one of Addition, Allocation, Divsion, Log, Multiplication, Pow, Sin, Subtraction.")
        sys.exit(1)

    name = sys.argv[1]
    filepath = f"results/jmh-result-{name}.json"
    jmh_data = load_jmh_results(filepath)
    plot_jmh_results(jmh_data, name)
